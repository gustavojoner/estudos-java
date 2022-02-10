#Receber e colocar 5 números ou mais em ordem crescente

lista = []

# solicita 5 numeros
for c in range(0, 5):
    n = int(input('Valor: '))
    if c == 0 or n > lista[-1]:
        lista.append(n)
    else:
        pos = 0
        while pos < len(lista):
            if n <= lista[pos]:
                lista.insert(pos, n)
                break
            pos += 1

# adiciona mais numeros
while True:
    r = str(input('Deseja inserir mais algum valor? [S/N] ')).strip().upper()[0]
    if r in 'Nn':
        break
    elif r in 'Ss':
        n = int(input('Valor:'))
        pos = 0
        while pos < len(lista):
            if n <= lista[pos]:
                lista.insert(pos, n)
                break
            pos += 1
    else:
        print('Opção inválida.')

print(f'Os valores digitados em ordem foram {lista}')