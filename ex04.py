#Verificador de número primo

n = int(input('Digite um número para saber se ele é Primo: '))
cont = 0
# verificacao (testa se os numeros anteriores podem dividir o numero solicitado)
for c in range(1, n+1):
    if n % c == 0:
        cont += 1

# se divisivel apenas duas vezes = primo
if cont == 2:
    print(f'O Número {n} é Primo.')
else:
    print(f'O Número {n} NÃO é Primo.')
