
let myAddPersonDialog = document.getElementById("add_person");
console.log("it works");
myAddPersonDialog.addEventListener('show.bs.modal', function (event) {
    let button = event.relatedTarget;
    let link = button.getAttribute('data-bs-link');
    let form = document.getElementById("add_person_form");
    form.setAttribute('action', link);
    let name = button.getAttribute('data-bs-name');
    let age = button.getAttribute('data-bs-age');

    let approveButton = document.getElementById("approve_person");
    let nameEdit = document.getElementById("person_name");
    let ageEdit = document.getElementById("person_age");
    let idField = document.getElementById("person_id");
    let mField = document.getElementById("mid");

    let dialogTitle = myAddPersonDialog.querySelector('.modal-title');

    if (button.getAttribute('data-bs-ident') === '#add') {
        idField.value = '0';
        nameEdit.value = '';
        ageEdit.value = '0';
        mField.value = 'POST';
        approveButton.textContent = "Add Person";
        dialogTitle.textContent = "Add Person";
    } else {
        idField.value = button.getAttribute('data-bs-id');
        nameEdit.value = name;
        ageEdit.value = age;
        mField.value = 'PUT';
        dialogTitle.textContent = "Edit Person";
        approveButton.textContent = "Update Person";
    }
});