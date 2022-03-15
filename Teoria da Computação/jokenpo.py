from random import choice
from time import sleep

opcoes = ["pedra", "papel", "tesoura"]                          #lista

logica = (("e", "d", "v"), ("v", "e", "d"), ("d", "v", "e"))    #3-upla

text = {"e": "Empate", "v": "Vitória!", "d": "Derrota!"}        #dicionario

print("=== JOKENPO ===")

while True:
    player = input("\nDigite sua jogada: ").lower()
    pc = choice(opcoes)
    
    if player in opcoes:                        #realiza uma validação para saber se a opção digitada esta dentro da lista de jogadas possiveis
        print(f"\nO computador jogou {pc}\n")
        sleep(2)
        print(text[logica[opcoes.index(player)][opcoes.index(pc)]])
        sleep(2)
    elif player == "sair":                      #saida do laço de repetição
        break
    else:                                       #caso a opção digitada pelo usuario não esteja na lista de jogadas
        print(f"Erro! Opções validas: {opcoes}")
        sleep(2)
    