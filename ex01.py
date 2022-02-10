#Retornar palavra ou frase, com mais de 3 letras, mostrando seu inverso e se é palíndromo ou não

texto =''
# palavra maior que 3 letras
while not len(texto) > 3:
    # remove espaços excesivos
    texto = str(input('Digite uma palavra ou frase: ')).strip()
    if len(texto) <= 3:
        print('A palavra ou frase deve conter mais que 3 letras.')

# substitui os espaços por nada e torna caixa alta
texto1 = texto.replace(" ", "").upper()

#inverte o texto
texto2 = texto1[::-1]

if texto1 == texto2:
    print('Palíndromo')
else:
    print(f'Seu inverso é "{texto2}".')
    