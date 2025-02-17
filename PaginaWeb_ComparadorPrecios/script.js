// ------------------------------ --------SCRIPT AXIOS-----------------------------------------------------
// async function getProductos(){
//     let productos = await axios.get("http://localhost:8084/productos/todos/");
//     console.log("los productos: ", productos.data);

//     let tablaProductos = document.getElementById('tablaProductos');
//     console.log(tablaProductos);

//     Array.from(productos.data).forEach(item => {
//         console.log(item);
//         tablaProductos.innerHTML = `
//         <table>
//         <tr>
//             <thead>
//                 <th>Nombre</td>
//                 <th>Marca</td>
//                 <th>Precio</td>
//                 <th>Categoria</td>
//             </thead>
//             <tbody>
//                 <td>${item.nombre}</td>
//                 <td>${item.marca}</td>
//                 <td>${item.precioVenta}</td>
//                 <td>${item.categorias.nombre}</td>
//             </tbody>
//         </tr>
//         </table>
//     `;
//     });
    
// }

// async function getProductos(){
//     let productos = await axios.get("http://localhost:8084/productos/todos/");
//     console.log("los productos: ", productos.data);

//     let tablaProductos = document.getElementById('tablaProductos');
//     console.log(tablaProductos);

//     // Crear la estructura de la tabla fuera del bucle
//     let tabla = document.createElement('table');
//     let thead = tabla.insertRow();
//     thead.insertCell().textContent = "Nombre";
//     thead.insertCell().textContent = "Marca";
//     thead.insertCell().textContent = "Precio";
//     thead.insertCell().textContent = "Categoria";
//     let tbody = tabla.appendChild(document.createElement('tbody'));

//     productos.data.forEach(item => {
//         console.log(item);

//         // Crear una nueva fila para cada producto
//         let row = tbody.insertRow();
//         row.insertCell().textContent = item.nombre;
//         row.insertCell().textContent = item.marca;
//         row.insertCell().textContent = item.precioVenta;
//         row.insertCell().textContent = item.categorias.nombre;
//     });

//     // Agregar la tabla completa al DOM una vez que se han agregado todas las filas
//     tablaProductos.appendChild(tabla);
// }

async function getProductos(){
    let productos = await axios.get("http://localhost:8084/productos/todos/");
    console.log("los productos: ", productos.data);

    let Productos = document.getElementById('verProductos');
    console.log(Productos);

    productos.data.forEach(item => {
        console.log(item);

        // Crear un div para cada producto
        let divProducto = document.createElement('div');
        divProducto.classList.add('producto'); // Agrega una clase para estilos

        // Crear divs para cada dato del producto
        let divCategoria = document.createElement('div');
        divCategoria.textContent = item.categorias.nombre;
        divCategoria.classList.add('Categoria');

        divProducto.appendChild(divCategoria);

        let divNombre = document.createElement('div');
        divNombre.textContent = item.nombre;
        divNombre.classList.add('Nombre');

        divProducto.appendChild(divNombre);

        let divMarca = document.createElement('div');
        divMarca.textContent = 'Marca: '+item.marca;
        divMarca.classList.add('Marca');

        divProducto.appendChild(divMarca);

        let divPrecio = document.createElement('div');
        divPrecio.textContent = 'Precio:' + item.precioVenta+'€';
        divPrecio.classList.add('Precio');

        divProducto.appendChild(divPrecio);

        let divOfertas = document.createElement('div');
        divOfertas.innerHTML = '<button>Ver ofertas</button>'; // Botón con HTML
        divOfertas.classList.add('btnVerOfertas')

        divProducto.appendChild(divOfertas);

        // Agregar el div del producto al contenedor principal
        Productos.appendChild(divProducto);
    });
}

async function getProductosPreciosProvedor() {
    let productos = await axios.get("http://localhost:8084/productos/provedor/precios/");
    console.log("los productos de los Provedores: ", productos);
}

function getBuscarProducto() {
    try {
        axios.id(`http://localhost:8084/productos/buscar/${id}`);
    } catch (error) {
        console.error("Producto No esta o No introducido bien el Codigo de barra ");
    }
}
/*
async function addProduct(id,descripcion, precioUnitario, marca = null, color = null) {
    try {
        let instance = await axios.post("http://localhost:8000/productos/alta", {
            codigo: id,
            descripcion: descripcion,
            precioUnitario: precioUnitario,
            marca: marca,
            color: color
        })
        console.log(instance);
    } catch (error) {
        console.error("Hubo un error: " + error.message);
    }
}

function deleteProduct(id) {
    try {
        axios.delete(`http://localhost:8000/productos/delete/${id}`);
    } catch (error) {
        console.error("Error al eliminar");
    }
}

function updateProduct(id, descripcion, precioUnitario, marca = null, color = null) {
    try {
        let instance = axios.put(`http://localhost:8000/productos/actualizar/${id}`, {
            codigo: id,
            descripcion: descripcion,
            precioUnitario: precioUnitario,
            marca: marca,
            color: color
        })
        console.log(instance);
    } catch (error) {
        console.error("Hubo un error: " + error.message);
    }
}
*/
getProductos();