// SCRIPT CARRITO
const carrito = document.getElementById('carrito');
const total = document.getElementById('total');
const productos = document.querySelectorAll('.producto');

let carritoData = [];

function agregarAlCarrito(nombre, precio) {
    const cantidadInput = event.target.parentElement.querySelector('input');
    const cantidad = parseInt(cantidadInput.value);

    const productoExistente = carritoData.find(item => item.nombre === nombre);

    if (productoExistente) {
        productoExistente.cantidad += cantidad;
        productoExistente.precioTotal += precio * cantidad;
    } else {
        carritoData.push({
            nombre,
            precio,
            cantidad,
            precioTotal: precio * cantidad
        });
    }

    renderCarrito();
}

function eliminarDelCarrito(nombre) {
    carritoData = carritoData.filter(item => item.nombre !== nombre);
    renderCarrito();
}

function renderCarrito() {
    carrito.innerHTML = '';
    let totalPrecio = 0;

    carritoData.forEach(item => {
        const row = document.createElement('tr');
        row.innerHTML = `
      <td>${item.nombre}</td>
      <td>${item.precio}€</td>
      <td>${item.cantidad}</td>
      <td>${item.precioTotal}€</td>
      <td><button data-nombre="${item.nombre}">Eliminar</button></td>
    `;
        carrito.appendChild(row);

        totalPrecio += item.precioTotal;
    });

    total.textContent = totalPrecio + '€';
}

productos.forEach(producto => {
    const button = producto.querySelector('button');
    button.addEventListener('click', () => {
        const nombre = producto.querySelector('p:first-child').textContent;
        const precio = parseFloat(producto.querySelector('p:nth-child(2)').textContent.replace('€', ''));
        agregarAlCarrito(nombre, precio);
    });
});

carrito.addEventListener('click', (event) => {
    if (event.target.tagName === 'BUTTON') {
        const nombre = event.target.dataset.nombre;
        eliminarDelCarrito(nombre);
    }
});