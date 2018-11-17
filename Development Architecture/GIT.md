Help it with Fork and Pull Request!
Para contribuir faça um Fork e submeta um Pull Request!

# CMD & BASH

## Shortcuts

Copy
```
Ctrl + Insert
```
Paste
```
Shift + Insert
```

## Command Line

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

## Remotes

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

#### Creating Branch on GIT BASH
```
1. $ git fetch origin -> updating the local repository with the latest dev
2. $ git checkout dev -> go to dev branch
3. $ git branch -> to see all the branches
4. $ git branch -D -> delete your oldest branch if is necessary
5. $ git checkout -b NAME-BRANCH -> it creates and switches
```

#### Removing a Wrong File from your Commit
```
$ git reset --soft HEAD^ -> To return your commit
$ git reset WrongFile.cs
$ git clean -i -> removing untracked files, choose whic will be removed
$git push -u -f YOUR_BRANCH
```

## Definições básicas
- Fluxo do GIT para mandar atualizações para um repositório: ADD -> COMMIT -> PUSH
- Fork: é a maneira de você clonar um repositório para ter uma cópia privada, assim pode-se alterá-la sem prejudicar o projeto original. No final pode-se fazer um 'pull request' para submeter o merge com o original.

## Merge and Conflicts
#### Git Stash
- https://git-scm.com/docs/git-stash
```
$ git stash pop -> It command will back your staged changes on branch (deleting the last staged changes from the tree). If occurs conflict, you must resolve, commit, push and continue your work.
$ git stash apply -> It command will back your staged changes on branch (maintaining the staged changes available). If occurs conflict, you must resolve, commit, push and continue your work.
```

#### Git Reset
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
_It merge your new alteration inside your last pull request ._
```
$ git add .
$ git commit --amend
```
####Local branch and remote branch conflict tags:
```
<<<<<<<< HEAD -> *Your Code/Branch*
>>>>>>>> e592fa8391d8a0f25f7e887d2071b7da2ffa9e95 -> *The Code/Branch that you are merging*
```

#### Basic Conflict Workflow
1. Resolve Conflict
2. Add and commit just the files that have been in conflict
3. Push it

# Basic Commands GIT no VI

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

