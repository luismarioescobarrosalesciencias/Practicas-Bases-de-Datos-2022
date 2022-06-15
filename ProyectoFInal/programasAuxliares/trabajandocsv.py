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
while (i <= 300):
    sol = id_generator(18)
    if sol not  in uniques:
        uniques.add(sol)
        i+=1

for x in uniques :
    print(x)
#tomo unos 50 de persona y los usamos para empleado y cliente , los demas see dvidiran
#guardamos csv
guarda = uniques  #guarda nuestros unicos

j =  0
interseccionCE = set ()

while(j<= 50):
    s = uniques.pop()
    interseccionCE.add(s)
    j+=1
print("..................................................................................")
#print(interseccion)
#print(len(uniques))

#guardamos
empleados = set()
k=1
while(k<=125):
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
