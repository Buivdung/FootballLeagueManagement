$(document).ready(()=>{
    console.log("sss")
})
function editById(id) {
    url = "http://localhost:8080/team/"+ id;
    $.get(url).done(function (data) {
        $("#id").val(data.id);
        $("#teamName").val(data.teamName);
        $("#coachName").val(data.coachName);
        $("#nationalName").val(data.nationalName);
    })
}
function deleteById(id) {
    url = "http://localhost:8080/team/delete/"+id;
    $("#deleteTeam").empty();
    $("#deleteTeam").append(
        `
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <a type="button" href="${url}" class="btn btn-primary">Delete</a>
        `
    );

}