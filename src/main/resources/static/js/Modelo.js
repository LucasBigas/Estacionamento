$(document).ready(function() {
    let userIdToDelete = null;

    // Ao clicar no botão de deletar, pega o id do usuário
    $(".js-delete").on("click", function() {
        userIdToDelete = $(this).data("id");
    });

    // Ao confirmar a exclusão, faz a requisição para deletar
    $("#btnsim").on("click", function() {
        if (userIdToDelete) {
            window.location.href = "/modelos/deletar/" + userIdToDelete;
        }
    });
});
