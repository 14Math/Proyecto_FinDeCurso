// --------------------SCRIPT MODAL--------------------------------
// Obtén los elementos
const modal = document.getElementById("ventanaModalLogin");
const btn = document.getElementById("abrirModalLogin");
const span = document.getElementsByClassName("cerrar");

// Abre la ventana modal al hacer clic en el botón
btn.onclick = function () {
    modal.style.display = "flex";
}

// Cierra la ventana modal al hacer clic en la "x"
span.onclick = function () {
    modal.style.display = "none";
}

// Cierra la ventana modal si el usuario hace clic fuera del contenido
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}