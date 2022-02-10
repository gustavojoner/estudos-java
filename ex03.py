#Programa anterior deve ser crescente ou decrescente

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
        print('Resposta inválida.')

# ordem crescente ou decrescente
while True:
    q = int(input('Deseja ver a ordem Crescente[1] ou Decrescente[2]? '))
    if q == 1:
        print(f'Os valores digitados em ordem Crescente foram {lista}')
        break
    elif q == 2:
        print(f'Os valores digitados em ordem Decrescente foram {lista[::-1]}')
        break
    else:
        print('Opção inválida.')
