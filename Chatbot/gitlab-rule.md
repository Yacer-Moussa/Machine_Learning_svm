# Gitlab usage

This document defines how to use GitLab and will ensure, that the style used by all developers is the same. Using the listed conventions is mandatory!

### General Rules for the Project

- Keep the boards up to date
- Push to the directory with the actual program code (src) with Pull Reqeusts (PR) only, 
  - simple doc changes, presentations, schedules etc. can be pushed directly to the main (please
  consider the commit messages)
- Language
  - gitlab comments and commit-messages completely in English
  - issues, comments in English

### General Rules for Branches

- Every Feature should be developed in a single Branch (="Feature-Branches")
- Every Branch (that's used for development) should be updated frequently via `git merge main`
- Before a Pull Request make sure, that the code fulfills the requirements of the **Definition of Done**

### Known Limitations

Some Limitation are known as of the writing of this document and can be solved with some workarrounds.

- Filtering Lists on the Issue-Boards by multiple Labels: this can be done by using the prefixed labels, e.g. "Architecture::done" and "Design::done"

## 1. Workflow

1. Create an [issue](#5-issues) based on the template. Assign it the right [action-label](#2-boards-and-lists) and place it in the **::todo-list** of your team.

2. Move issue to **::doing**, assign the responsible developers and create a [branch based on the issue](#3-branches)   

3. Work on issue:
- Document progress via tasks

5. After (successfull) review a **merge-request** can be created and the issue can be moved to **::merge**

6. After the **sprint-review** the issue should be closed and moved into **::done**

### **Updating the Boards frequently is mandatory! Developers are responsible for their assigned issues by themselves!**

All other boards shouldn't be used in the active development-process. They're either depricated or there for legacy-reasons.

As mentioned, all Labels representing the states exist twice in GitLab. The further explaination will ignore the team-specific prefix!

| State | Meaning |
|-|-|
| `::todo` | Issues is planned for the current sprint but active development hasn't stated yet |
| `::doing` | Issue is in active development |
| `::testing` | Development of issue is done (= acceptance criteria are met), it waits for a code testing by the Team |
| `::merge` | Corresponding branch of the issue can be merged |
| `::done` | Development of the Issue is done. No more steps ahead |

## 3. Branches

There's one **main**-branch that shouldn't be used for active development! All development should happen in additional branches based on their features.

All feature-branches should be created based of an existing issue and named the following way:

- Issue: Issuenumber-"Some precise words to describe the issue"-Developer
- Developer: Anna Otto
- **Branch-Name: 42-ShortDescription-AO**


### Dos and don'ts for branches
**Dos**
- only create branches that deal with a specific feature
- update the branch quite frequently
- let the branch live as short as possible and as long as necessary

**Don'ts**
- don't create long living branches like `dev`
- don't use commits to transfer from pc1 to pc2
- don't push every two seconds some not-working states

## 4. Naming-Conventions and Commit-Messages

In general all information should be written in english and contain only the characters [a-zAZ0-9_-].

To ensure a convinient and uniform style of commit-messages, they should be created respecting the following convention:

1. Name of the Branch
2. Action of the commit ([actions](#5-issues))
3. A short description whats done

- Branch: "42-MyIssue-AO"
- Action: ADD
- Description: useful function added
- **Commit-message: "#42-MyIssue-AO-ADD: useful function added"**

Using the number of an issue let GitLab connect the commit to the issue

For cases that don't have any issue connected (like fixing typos in the documentation), simply use the area of the commit instead of the issue-name and number.

E.g.
**"Doc-FIX: typos fixed"**

Merge-Requests should contain the same prefix as normal commit messages with the action set to `MERGE`. The description should include the branch merged into.

**Merge-message: "#42-MyIssue-AO-MERGE: merged into main"**

When merging make shure to check **delete source branch** and **squash commits**

[![Merge_Branch.png](https://i.imgur.com/X0iMQAV.png)](https://i.imgur.com/X0iMQAV.png)

## 5. Issues

For each Task there should be an issue. As this project uses "Feature-Branches", most of the time issues should have a corresponding branch (at least if there's some active development happening). In addition the whole project-menagement should be handled via issues. Not every task in the project-management has something todo with developing software in this project. This is why Issues should be tagged with two labels:
1. Team::State ([lists](#2-boards-and-lists))
2. the action of the issue (see below)

| action | Description |
|-|-|
| `Action::ADD` | adding some new functionality |
| `Action::CHG` | changing an existing functionality |
| `Action::DEL` | removing an existing functionality |
| `Action::FIX` | fixing an existing functionality |
| `Action::REF` | refactoring existing sourcecode |
| `Action::RES` | require some research of a specific topic |

The developers working on an issue should be assigned to it.

When defining the issue, use the following points as guidelines:
- be always as precise as possible
- don't be verbose!
- use tools **markdown** provide to create visual appealing issues
  - `commands`: use backticks \` \` to highlight single commands inside the text
  - `acceptance criteria`: use \- \[ ] to create checkboxes for the acceptance criteria
  - `code-snippets`: use six \`\`\`csharp \`\`\` backticks to embrace the code-snippet. 

If an issue has multiple "sub-tasks" ore more than one person is working on it, use additional **tasks** of the issue to split the work. For the **tasks** the same rules and labels as for **issues** should be applied!.

## 6. Merge Requests

Since this project has a growing complexity, it's very easy that **Merge Requests** destroy or break some existing functionality of the current project's state. Extensive testing of the state of a Merge Request is mandatory before merging into **main**.


## Helpful links

- https://docs.gitlab.com/ee/development/code_review.html
- https://www.gitkraken.com/blog/code-review
- https://blog.codacy.com/how-to-code-review-in-a-pull-request/
- https://www.pullrequest.com/blog/11-ways-to-create-pull-requests-that-are-easy-to-review/
