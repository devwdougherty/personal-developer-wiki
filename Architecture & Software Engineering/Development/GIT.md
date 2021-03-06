# CMD & BASH

## Environment

Change the git core editor
e.g.: (nano or vi)
```
git config --global core.editor "nano"
```

### SSH

Get your currently SSH public key (assuming the name)
```
$ cat ~/.ssh/id_ed25519.pub
```

### Difference between ~ (tilde) and caret (^)

~ Use on local git -> Go back a number of commits in a "straight line".
^ Use on merge commits  ->  Go back a number of commits in a tree of forks and merges.

## Commands

Clonar repositório
```
$ git clone https://willian-dougherty@bitbucket.org/barbosa/java-aw.git
```
Criar um repositório
```
$ git init
```
Status do seu repositório git
```
$ git status
```
Preparar o arquivo para commit
```
$ git add / $ git add . || $ git add -A (all)
```
Commit com mensagem
```
$ git commit -m "Mensagem"
```
Commitar o repositório local para o servidor (branch master)
```
$ git push origin master
```
Puxar os commits do servidor (branch master) para o repositório local
```
$ git pull origin master
```
Puxar todos os commits para atualizar o repositório local
```
$ git pull -all
```
Criar um novo branch
```
$ git branch nome-branch
```
Para trabalhar com uma nova branch é necessário dar checkout (para separá-lo do master)
```
$ git checkout nome-branch
```
Apontar branch local para a do server
```
$ git push -u origin <branch>
```
Dar merge entre 2 branchs de maneira rápida
```
$ git remote update (It updates your local branch list with server branches)
$ git checkout BRANCH-YOU-WANT-TO-MERGE-IN
$ git pull
$ git checkout YOUR-BRANCH-TO-MERGE
$ git pull
$ git merge BRANCH-YOU-WANT-TO-MERGE-IN
```
Deletar um branch
```
$ git branch -d nome-branch
$ git diff
```
Se referir a tudo no git (código, parâmetro, etc)
```
$ .
```
Para voltar um commit para o topo da árvore
```
$ git cherry-pick commit-code
```
Retornar a versão do código para um commit específico
```
$ git checkout commit_code
```
Atualizar (hard) a branch origin com a dev local
```
$ git push -u -f origin
```
Visualizar o usuário atual do git
```
git config user.name
git config user.email
```
Mudar de usuário no git
```
$ git config --global user.email "myemail@gmail.com"
```
Salvar suas credenciais (password)
```
git config credential.helper store
```
Para forçar um push no server (branch específica)
```
$ git push -f origin nome-branch
```
Para forçar que seu repositório local esteja igual ao do server
```
$ git fetch origin dev
```
Procure por algo em seu código (área de trabalho):
```
$ git grep "foo()"
```
Visualizar os arquivos de um repositório git
```
$ git-ls-files
```

## GIT Operations

### Juntar vários commits em um só (rebase & squash)

```
$ git rebase -i HEAD~2
```
_Obs: The number after HEAD~ refers to the quantity of commits that you want to join._

Da lista de commits, deixe o primeiro como p (pick). Coloque s (squash) nos commits abaixo. Escreva a nova mensagem para o commit unificado.

### Remotes

Para adicionar um remote
```
$ git remote add <nome-do-remote><URL do repositório>
```
_Ex: git remote add upstream https://github.com/ORIGINAL_OWNER/ORIGINAL_REPOSITORY.git_

Para ver os remotes e URLS associadas
```
$ git remote -v
```
Para deletar um remote
```
$ git remote rm <nome-do-remote>
```
Para mergear seu repositório local com seu remote principal (FORK)
```
$ git fetch upstream <nome do seu remote>
$ git checkout master
$ git merge upstream/master <remote>/<sua branch de trabalho>
```
Baixar todas as branchs do repositório servidor para o local
```
$ git remote update
```

### Creating Branch on GIT BASH

```
1. $ git fetch origin -> updating the local repository with the latest dev
2. $ git checkout dev -> go to dev branch
3. $ git branch -> to see all the branches
4. $ git branch -D -> delete your oldest branch if is necessary
5. $ git checkout -b NAME-BRANCH -> it creates and switches
```

### Removing a Wrong File from your Commit

**Undoing your changes**
```
$ git reset --soft HEAD^ -> To return your commit
$ git reset WrongFile.cs
$ git clean -i -> removing untracked files, choose whic will be removed
$ git push -u -f YOUR_BRANCH
```

**Without undoing your changes**
```
$ git reset --soft HEAD~1
$ git reset HEAD <file>
$ git rm --cached <file>
$ git commit --amend
```
OR
```
$ git checkout HEAD^ -- /path/to/file
$ git commit -am "revert changes on this file, not finished with it yet"
$ git push
$ git checkout HEAD^ -- /path/to/file
```

**Remove a committed file included on a new .gitignore**
```
$ git rm -r --cached . (remove all the files from the index)
$ git add . (add all the files again, but now, the specified file does`nt,  because it is already inclued on .gitignore.
OR
git rm --cached <arquivo> (if you`re certain that you want to remove it specified file)
```

### Undo a git commit that was not pushed

**1 - Undo commit and keep all the files staged**
```bash
$ git reset --soft HEAD~;
```

**2 - Undo commit and unstage all files**
```bash
$ git reset HEAD~;
```

**3 - Undo commit and completely remove all changes**
```bash
$ git reset --hard HEAD~;
```

**Just to rewrite the commit meessage use:**
```bash
$ git -amend
```

### Git Subtree
Steps to add a remote repository as subtree in your project:
```
git remote add -f pistache-rest-api https://github.com/oktal/pistache.git
git subtree add --prefix Telemetry/API pistache-rest-api master --squash
git fetch pistache-rest-api master
git subtree pull --prefix Telemetry/API pistache-rest-api master --squash
```

## Definições básicas

- Fluxo do GIT para mandar atualizações para um repositório: ADD -> COMMIT -> PUSH
- Fork: é a maneira de você clonar um repositório para ter uma cópia privada, assim pode-se alterá-la sem prejudicar o projeto original. No final pode-se fazer um 'pull request' para submeter o merge com o original.

## Merge and Conflicts

### Git Stash
- https://git-scm.com/docs/git-stash
```
$ git stash pop -> It command will back your staged changes on branch (deleting the last staged changes from the tree). If occurs conflict, you must resolve, commit, push and continue your work.
$ git stash apply -> It command will back your staged changes on branch (maintaining the staged changes available). If occurs conflict, you must resolve, commit, push and continue your work.
```

### Git Reset
Reset your modifications (doesn't committed yet) on current branch to 1 commit behind (HEAD -> First of the GIT Tree) 
```
$ git reset --hard HEAD
```
^ -> the number of carets determine how many commits you will back.
```
$ git reset --hard HEAD ^^
```
Reset your branch with the modifications that have been last committed on current branch
```
$ git reset --soft HEAD^
```

Transfering your code to another branch
```
$ git stash
$ git checkout nova_branch
$ git stash apply
```

Adding new simple code to Pull Request
_It merge your new alteration inside your last pull request.
Obs: Your remote branch could diverge your local branch. Amend is supposed to replace, if you are certain of your code force it._
```
$ git add .
$ git commit --amend
```
or
```
$ git commit --amend -f
```
Obs: Your remote branch will could diverge your local branch. Amend is supposed to replace, if you are certain of your code force it.
### Local branch and remote branch conflict tags:
```
<<<<<<<< HEAD -> Your Code/Branch
>>>>>>>> e592fa8391d8a0f25f7e887d2071b7da2ffa9e95 -> The Code/Branch that you are merging
```

### Basic Conflict Workflow
1. Resolve Conflict
2. Add and commit just the files that have been in conflict
3. Push it

# VI Basic Commands (GIT example)

```
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

# Nano Basic Commands
```
Ctrl ^ O = Write Out
Ctrl ^ X = Exit
```

# Q&A

*Q: How to apply a new gitignore on an existing repository?*

*A:*
```
$ git rm -r --cached .

$ gid add .

$ git commit -m ".gitignore is now working"
```

# Bibiliografia

## Articles and Tutorials

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

## Videos

- Git & GitHub: Introduction (Codecourse) - https://www.youtube.com/watch?v=DR7MLaAKcUk&list=PLfdtiltiRHWFEbt9V04NrbmksLV4Pdf3j
