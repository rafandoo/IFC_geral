#include <sys/types.h>
#include <sys/wait.h>
#include <stdio.h>
#include <unistd.h>

int valor = 5;

int main () 
{
    pid_t pid = fork();
    if (pid == 0) {
        valor += 15;
    } else if (pid > 0) {
        //wait(&valor);
        printf("Valor: %d", valor);
    }
    return 0;
}