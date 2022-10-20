# GIT Command Line

## Environment

### Properties

Change the git core editor e.g.: (nano or VI)

```bash
$ git config --global core.editor "nano"
```

Change the git config properties of your environment (username, name, etc)

```bash
$ git config --global --edit
```

Checking the current git user

```bash
git config user.name
git config user.email
```

Changing the git user

```bash
$ git config --global user.email "mynewuser@fsspx.com"
```

Saving your credentials (password)

```bash
git config credential.helper store
```

Updating your local repository name to matches origin name (server)

```bash
git remote set-url origin https://bitbucket.org/williandougherty/my-app.git
```

### SSH

Get your currently SSH public key (assuming the name)

```bash
$ cat ~/.ssh/id_ed25519.pub
```

### Syntax 

Difference between ```~``` (tilde) and ```^``` (caret)

- ```~``` Use on local git => Go back a number of commits in a "straight line".
- ```^``` Use on merge commits =>  Go back a number of commits in a tree of forks and merges.

## Common Commands in Dev Flow

```bash
$ git clone https://willian-dougherty@bitbucket.org/barbosa/java-aw.git # Clone a repository
$ git init # Initialize a local repository
$ git status # Get a repository/content status
$ git add Something.java  || git add . || git add -A # Prepare one specified or all the files to be committed.
$ git commit -m "fsspx" # Commit with message
$ git push origin master # Push to server repository (branch master) a commit from local repository.
$ git pull origin master # Pull server repository commits (branch master) to local repository
$ git checkout -b nome-branch # Create a new local branch from the current one and already checkout to it
$ git push -u origin fsspx_new_branch # Appoint and push the local branch content to a new/existent one in server repository.
$ git push --set-upstream origin fsspx_new_branch 
$ git branch # To see all the branches
```

Merge two branches in a quick way

```bash
$ git remote update # It updates your local branch list with server branches
$ git checkout BRANCH-YOU-WANT-TO-MERGE-IN
$ git pull
$ git checkout YOUR-BRANCH-TO-MERGE
$ git pull
$ git merge BRANCH-YOU-WANT-TO-MERGE-IN
```

Deleting a branch

```bash
$ git branch -d branch-name
```

To back a commit to the top of git tree

```bash
$ git cherry-pick commit-code
```

Return the code version to a specific commit

```bash
$ git checkout commit_code
```

Forcing the update of an origin branch with the version of local branch

```bash
$ git push -u -f origin
$ git push -u -f origin branch-name
```

Force your local repository to be equal the server

```bash
$ git fetch origin dev # dev -> it's branch name
```

Search for something in your code

```bash
$ git grep "foo()"
```

## GIT Operations

### Rebase & Squash

Join a number of commits into a master on (rebase & squash)

```bash
$ git rebase -i HEAD~2 # Note: The number after HEAD~ refers to the quantity of commits that you want to join.
```

From the commit list, leave the first on as 'p' (pick). Put 's' (squash) in the below commits. Write a new message for the 
unified commit.

### Remotes

To add a new remote

```bash
$ git remote add <nome-do-remote><URL do repositório>
# ex: git remote add upstream https://github.com/ORIGINAL_OWNER/ORIGINAL_REPOSITORY.git
```

To check the remote list and its URLs

```bash
$ git remote -v
```

To delete a remote

```bash
$ git remote rm <nome-do-remote>
```

To merge your local repository into your remote (FORK)

```bash
$ git fetch upstream <remote-name>
$ git checkout master
$ git merge upstream/master <remote>/<your-work-branch>
```

Download all branches from server repository to local

```bash
$ git remote update
```

### Undoing or Resetting GIT

Removing a wrong file from your previous commit

```bash
# undoing your changes - forcing push
$ git reset --soft HEAD^ # To return your commit
$ git reset WrongFile.cs
$ git clean -i # removing untracked files, choose which one will be removed
$ git push -u -f YOUR_BRANCH
```


```bash
# Without undoing your changes
$ git reset --soft HEAD~1
$ git reset HEAD <file>
$ git rm --cached <file>
$ git commit --amend
```
OR
```bash
$ git checkout HEAD^ -- /path/to/file
$ git commit -am "reverting changes at this file, not finished yet"
$ git push
$ git checkout HEAD^ -- /path/to/file
```

Undoing commit Using **ORIG_HEAD (2022)**

```bash
$ git commit -m "Something terribly misguided"
$ git reset HEAD^
[ Edit files as necessary ]
$ git add .
$ git commit -c ORIG_HEAD
```

Remove a committed file included at a new ```.gitignore```

```bash
$ git rm -r --cached . # remove all the files from the index
$ git add . # add all the files again, but now, not the specified file, because it is already included at .gitignore.
[ OR ]
git rm --cached <file> # if you're certain that you want to remove it specified file
```

Undo a git commit that was not pushed

```bash
# Undo commit and keep all the files staged
$ git reset --soft HEAD~;
# Undo commit and unstage all files**
$ git reset HEAD~;
# Undo commit and completely remove all changes**
$ git reset --hard HEAD~;
```

To rewrite the commit message

```bash
$ git commit --amend -m "an updated commit message"
```

### Git Subtree

Steps to add a remote repository as subtree in your project:

```bash
git remote add -f pistache-rest-api https://github.com/oktal/pistache.git
git subtree add --prefix Telemetry/API pistache-rest-api master --squash
git fetch pistache-rest-api master
git subtree pull --prefix Telemetry/API pistache-rest-api master --squash
```

### Merge and Conflicts

Basic Conflict Workflow
1. Resolve the code conflicts
2. Add the fixed files and commit just the files that have been in conflict
3. Push it

Git stash

```bash
$ git stash # save temporary in the memory your changes
[ and ]
$ git stash pop # This command will back your staged changes on branch (deleting the last staged changes from the tree). 
                # If occurs conflict, you must resolve, commit, push and continue your work.
$ git stash apply # This command will back your staged changes on branch (maintaining the staged changes available). 
                  # If occurs conflict, you must resolve, commit, push and continue your work.
```

Transferring your code to another branch

```bash
$ git stash
$ git checkout new branch
$ git stash apply
```

Adding a new piece of code to your last commit => Pull Request

```bash
# It merge your new alteration inside your last commit => pull request.
# Note: Your remote branch could diverge from your local branch. Amend is supposed to replace, if you are certain of your code force it.
$ git add .
$ git commit --amend
```

or

```bash
$ git commit --amend -f
```

Local and remote branch conflict tags:

```bash
<<<<<<<< HEAD -> Your Code/Branch
>>>>>>>> e592fa8391d8a0f25f7e887d2071b7da2ffa9e95 -> The Code/Branch that you are merging
```

### Git Reset

Reset your modifications (doesn't committed yet) on current branch to 1 commit behind (HEAD -> First of the GIT Tree) 

```bash
$ git reset --hard HEAD
```

```^``` => the number of carets determine how many commits you will back.

```bash
$ git reset --hard HEAD^^
```

Reset your branch with the modifications that have been last committed on current branch

```bash
$ git reset --soft HEAD^
```

## VI Basic Commands (GIT example)

```bash
q -> quit
w -> write
: -> to command line (to digit)
e -> edit
Page up / Page down -> navigate in the code/file
wq -> When you're writing a commit message -> Write and Quit
Shiftl + Insert -> Copy
tig -> To see the Git Tree
git branch -a -> All branches
git pull origin dev -> updating the local dev with server dev
j - > Dowside line by line
k -> Upside line by line
```

## Nano Basic Commands

```bash
Ctrl ^ O = Write Out
Ctrl ^ X = Exit
```

## Q&A

*Q: How to apply a new gitignore on an existing repository?*

*A:*

```bash
$ git rm -r --cached .

$ gid add .

$ git commit -m ".gitignore is now working"
```

## References

### Articles and Tutorials

- [GIT em Equipe](http://joepreludian.github.io/tutorial/2014/10/01/git-em-equipe.html)
- [SSH no GIT](https://confluence.atlassian.com/bitbucket/set-up-an-ssh-key-728138079.html#SetupanSSHkey-ssh1)
- [SSH Keys](https://confluence.atlassian.com/bitbucket/ssh-keys-935365775.html)
- [Checking for existing SSH Keys](https://docs.github.com/en/enterprise-server@3.0/github/authenticating-to-github/connecting-to-github-with-ssh/checking-for-existing-ssh-keys)
- [Adding a new SSH key to your GitHub account](https://docs.github.com/en/enterprise-server@3.0/github/authenticating-to-github/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account)
- [Set up additional SSH Keys](https://confluence.atlassian.com/bitbucket/set-up-additional-ssh-keys-271943168.html#SetupadditionalSSHkeys-ssh1c5)
- [URL HTTP -> SSH](https://www.udacity.com/wiki/ud775/git-bash-copy-paste)
- [About GIT Ignore](https://fjorgemota.com/gitignore-ou-como-ignorar-arquivos-no-git/)
- [Create GIT Ignore](https://www.gitignore.io/)
- [Configuring a remote for a fork](https://help.github.com/articles/configuring-a-remote-for-a-fork/)
- [Syncing a fork](https://help.github.com/articles/syncing-a-fork/)
- [Os 4 comandos do Git que todo desenvolvedor deveria conhecer](https://imasters.com.br/desenvolvimento/os-4-comandos-git-que-todo-desenvolvedor-deveria-conhecer)
- [Basic writing and formatting syntax - Github File](https://help.github.com/articles/basic-writing-and-formatting-syntax/)
- [Resolvig the conflict with GIT Branches between GIT branches](https://confluence.atlassian.com/bitbucket/resolve-merge-conflicts-704414003.html#Resolvemergeconflicts-ResolvingtheconflictwithGitbranches)
- [Git subtree: the alternative to Git submodule](https://www.atlassian.com/git/tutorials/git-subtree)
- [How to merge two or multiple git repositories into one](https://medium.com/altcampus/how-to-merge-two-or-multiple-git-repositories-into-one-9f8a5209913f)
### Fixing Commits
- [Git: Remove committed file after push](https://stackoverflow.com/questions/18357511/git-remove-committed-file-after-push)
- [How To Remove Files From Git Commit](https://devconnected.com/how-to-remove-files-from-git-commit/)
- [Numerous undo possibilities in Git](https://docs.gitlab.com/ee/topics/git/numerous_undo_possibilities_in_git/#undo-remote-changes-without-changing-history)

### Videos

- Git & GitHub: Introduction (Codecourse) - https://www.youtube.com/watch?v=DR7MLaAKcUk&list=PLfdtiltiRHWFEbt9V04NrbmksLV4Pdf3j
