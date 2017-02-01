nomes = []
salarios = []

def calcularSalarioComGratificacao(funcionario):
	i=0
	for n in nomes:
		if n==nome:
			salarioCorrecao = salarios[i]*1.25
			print("Salario corrigido: " + str(salarioCorrecao))
		i=i+1

while True:
	print("### Controle de Cadastro de Funcionarios da Biblioteca###")

	print("1 - Cadastrar")
	print("2 - Apagar")
	print("3 - Mostrar")
	print("4 - Exibir salario com gratificacao")
	print("5 - Sair")

	opc = int(input("Digite o numero da sua opcao: "))

	if opc==1:
		nomes.append(input("Digite o nome a ser cadastrado:"))
		salarios.append(float(input("Digite o salario:")))
	elif opc==2:
		nome = input("Informe o nome a ser apagado:")
		i=0
		for n in nomes:
			if n==nome:
				del(nomes[i])
				del(salarios[i])
			i=i+1
	elif opc==3:
		i=0
		for n in nomes:
			print("Nome:", n)
			print("Salario:", salarios[i])
			i=i+1
	elif opc==4:
		nome = input("Informe o nome do funcionario:")
		calcularSalarioComGratificacao(nome)
	elif opc==5:
		print("Saindo...")
		break		

