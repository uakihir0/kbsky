# Documentation for Agents

## Overview

This repository is an API client library for [Bluesky](https://bsky.app/) (Kotlin Multiplatform compatible). It is implemented based on the AT Protocol (atproto).

## Important Concepts

### Lexicon and NSID

**Lexicon** is the schema definition language of the AT Protocol, defining API endpoints, record types, and validation rules. Each Lexicon is identified by an **NSID (Namespace Identifier)** (reverse DNS format).

Examples:

- `com.atproto.identity.resolveHandle` - API to resolve DID from handle
- `app.bsky.feed.post` - Schema definition for post records
- `app.bsky.feed.getTimeline` - Timeline retrieval API
- `chat.bsky.convo.sendMessage` - DM message sending API

Main namespaces:

- `com.atproto.*` - AT Protocol core functionality
- `app.bsky.*` - Bluesky application-specific features (feeds, profiles, social graph, etc.)
- `chat.bsky.*` - Bluesky direct messaging (DM) functionality

### XRPC

**XRPC** is the HTTP API system of the AT Protocol. All endpoints are accessed in the format `/xrpc/{NSID}`.

- **Query (GET)**: Data retrieval (read-only)
- **Procedure (POST)**: Data creation, update, and deletion

### Referencing Lexicon Specifications

When implementing, always verify against the latest Lexicon specifications:

- **Lexicon definition files**: [bluesky-social/atproto/lexicons](https://github.com/bluesky-social/atproto/tree/main/lexicons)
  - `com/atproto/` - AT Protocol core functionality
  - `app/bsky/` - Bluesky application functionality
  - `chat/bsky/` - Bluesky DM functionality
- **Specification**: [AT Protocol Lexicon Specification](https://atproto.com/specs/lexicon)

## Directory Structure

- **`core/`**: Core library for AT Protocol and Bluesky API (`com.atproto.*`, `app.bsky.*`, `chat.bsky.*`)
- **`auth/`**: OAuth authentication functionality
- **`stream/`**: Real-time event streaming (`subscribeRepos`)
- **`all/`**: Package containing all modules
- **`plugins/`**: Gradle build configuration

## Testing Method

After making changes, always run the following test (no authentication required):

```shell
./gradlew core:jvmTest --tests "work.socialhub.kbsky.com.atproto.identity.ResolveHandleTest.testResolveHandle"
```

If network access is unavailable, verify successful build:

```shell
./gradlew jvmJar
```

## Implementation Guidelines

### NSID and Package Structure Correspondence

- Lexicon NSIDs correspond to package structure
- Example: `app.bsky.feed.post` → `core/src/commonMain/kotlin/work/socialhub/kbsky/app/bsky/feed/post/`

### Verifying Consistency with Lexicon

When implementing, verify against the corresponding Lexicon definition (JSON):

**Checklist for records/types:**

- Are all fields implemented?
- Are Lexicon types (string, integer, boolean, ref, union, etc.) correctly mapped to Kotlin types?
- Are `required` fields non-nullable?
- Are constraints (`maxLength`, `minLength`, `maxGraphemes`, `pattern`, etc.) implemented?
- Are default values reflected?

**Checklist for XRPC endpoints:**

- Are `parameters` (URL parameters) implemented?
- Is `input` (request body) implemented?
- Is `output` (response) implemented?
- Is error handling for `errors` definitions implemented?

### Testing

- Place test classes in `core/src/jvmTest/kotlin/`
- Test serialization/deserialization of all fields
- Verify that validation rules function correctly

## Important Implementation Notes

### Special Requirements for chat.bsky (DM Feature)

When implementing `chat.bsky.*` APIs, note the following:

**Authentication Requirements:**

- Accessing DM functionality requires an app password with "Allow access to direct messages" scope
- Regular app passwords cannot access DM APIs

**Service Proxy:**

- `chat.bsky.*` endpoints are proxied to `did:web:api.bsky.chat` via the user's PDS instance
- The appropriate service DID must be set in proxy headers when making requests
