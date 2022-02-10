#Retornar o maior e menor número

maior = menor = 0

# criando um laço de repetições
for c in range(0, 5):
    n = int(input('Digite um número: '))
    c += 1
    if c == 1:
        maior = menor = n
    else:
        if n > maior:
            maior = n
        if n < menor:
            menor = n

print(f'O maior número foi {maior} e o menor {menor}.')
