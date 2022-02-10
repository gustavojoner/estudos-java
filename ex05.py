#Converter unidades de medida
n = float(input('Insira um valor: '))
n2 = 0
while True:
    u = str(input(f'O valor {n} está em qual unidade de medida?'
                  f'\nOpções: Metros, Pes, Centímetros, Polegadas, Milímetros, Quilometros e Milhas.'
                  f'\nSua Opção: ')).strip().lower()

# convertendo para metros como medida padrao
    if u in 'metros':
        n2 = n
        u = 'm'
        break
    elif u in 'pes':
        n2 = n * 0.3048
        u = 'ft'
        break
    elif u in 'centimetros':
        n2 = n * 100
        u = 'cm'
        break
    elif u in 'polegadas':
        n2 = n * 0.0254
        u = 'inch'
        break
    elif u in 'milimetros':
        n2 = n * 0.001
        u = 'mm'
        break
    elif u in 'quilometros':
        n2 = n * 1000
        u = 'Km'
        break
    elif u in 'milhas':
        n2 = n * 1609.34
        u = 'mile'
        break
# informando erro
    else:
        print('Opção inválida.')

while True:
    c = str(input(f'Para qual unidade deseja converter?'
                  f'\nOpções: Metros, Pes, Centímetros, Polegadas, Milímetros, Quilometros e Milhas.'
                  f'\nSua Opção: ')).strip().lower()

# convertendo de metros para unidade desejada
    if c in 'metros':
        n2 = n2
        c = 'm'
        break
    elif c in 'pes':
        n2 = n2 * 3.28084
        c = 'ft'
        break
    elif c in 'centimetros':
        n2 = n2 * 100
        c = 'cm'
        break
    elif c in 'polegadas':
        n2 = n2 * 39.3701
        c = 'inch'
        break
    elif c in 'milimetros':
        n2 = n2 * 1000
        c = 'mm'
        break
    elif c in 'quilometros':
        n2 = n2 * 0.001
        c = 'Km'
        break
    elif c in 'milhas':
        n2 = n2 * 0.000621371
        c = 'mile'
        break
# informando erro
    else:
        print('Opção inválida.')

print(f'{n} {u} são {n2} {c}.')