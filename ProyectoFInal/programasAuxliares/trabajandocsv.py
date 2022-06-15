# Leer el csv
# divir los datos de persona en 6 rubros   (curps )
import random
import string
#sol = ""
#generar curps unicos
uniques = set()
def id_generator(size, chars=string.digits):
    return ''.join(random.choice(chars) for _ in range(size))
sol=""
i = 0
while (i <= 2000):
    sol = id_generator(18)
    if sol not  in uniques:
        uniques.add(sol)
        i+=1
print("UNICOS")
#for x in uniques :
#    print(x)


#tomo unos 50 de persona y los usamos para empleado y cliente , los demas see dvidiran
#guardamos csv
guarda = set()  #guarda nuestros unicos
for x in uniques:
    guarda.add(x)


j =  0
interseccionCE = set ()
while(j<= 100):
    s = uniques.pop()
    interseccionCE.add(s)
    j+=1
print("..................................................................................")
#print(interseccion)
#print(len(uniques))

#guardamos
empleados = set()
k=1
while(k<=1000):
    s = uniques.pop()
    empleados.add(s)
    k+=1
empleados = empleados.union(interseccionCE)
m=1
clientes = set ()
while(len(uniques)>0):
    s = uniques.pop()
    clientes.add(s)
clientes = clientes.union(interseccionCE)

#print(len(empleados))
#print(len(clientes))
#print(len(uniques))
#print(len(empleados.union(clientes)))
print("longitud")

if empleados.union(clientes) == guarda:
    print("okey")
else:
    print("MALLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL")
    print(empleados.union(clientes).difference(guarda))
    print("mallllllllllllllllllllllll")
    print(guarda.difference(empleados.union(clientes)))


#escribir un archivo para guarda
#escribir un archvo para empleados
#escribir un archivo para los derivados de empleados
def escribe(nombre,conjunto):
    with open(nombre, 'w') as f:
        for x in conjunto:
            f.write(x)
            f.write('\n')


escribe('Persona.txt',guarda)
escribe('Cliente.txt',clientes)
escribe('Empleados.txt',empleados)
'''
with open('Persona.txt', 'w') as f:
    for x in guarda:
        f.write(x)
        f.write('\n')

with open('Cliente.txt', 'w') as f:
    for x in clientes:
        f.write(x)
        f.write('\n')

with open('Empleados.txt', 'w') as f:
    for x in guarda:
        f.write(x)
        f.write('\n')
'''

#dividir empleados
taquero = set () #230
parrillero = set () #200
cajero = set () # 70 cajeros
tortillero = set ()
mesero = set () #200
repartidor = set () #80



def dividir(conjunto1,conjunto2,partes):
    count = 0 ;
    while(count <partes):
        s = conjunto1.pop()
        conjunto2.add(s)
        count+=1

dividir(empleados,taquero,230)
escribe('taquero.txt',taquero)

dividir(empleados,parrillero,220)
escribe('parrillero.txt',parrillero)

dividir(empleados,cajero,80)
escribe('cajero.txt',cajero)

dividir(empleados,mesero,240)
escribe('mesero.txt',mesero)

dividir(empleados,repartidor,100)
escribe('repartidor.txt',repartidor)

dividir(empleados,tortillero,len(empleados))
escribe('tortillero.txt',tortillero)
