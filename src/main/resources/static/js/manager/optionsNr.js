let modalVisible = false;
let selectedNrId = null

document.addEventListener('click', function(event) {
    const btnOptions = document.getElementById('options');
    const ModalAdd = document.getElementById('addModal');
    const target = event.target;

    if (modalVisible && !btnOptions.contains(target) && !target.closest('button')) {
        hideModalOptionsNr();
    }

    if(modalVisible && !ModalAdd.contains(target) && !target.closest('button')){
        hideModalAddNr()
    }

});

document.getElementById("btnOptionUser").addEventListener('click',showModalOptionsNr)

function showModalOptionsNr(button){
    const options = document.getElementById('options');
    const rect = button.getBoundingClientRect();
    selectedNrId = button.closest('tr').getAttribute('data-id');

    const marginLeft = 125;
    const marginTop = -40;

    let modalLeft = rect.left - marginLeft;
    let modalTop = rect.top + marginTop;

    options.style.top = `${modalTop}px`;
    options.style.left = `${modalLeft}px`;

    options.style.display = 'block';
    modalVisible = true;
}
function hideModalOptionsNr(){
    const options = document.getElementById('options');
    options.style.display="none";
}

function redirectToQuestionBynR(){
    window.location.href="/question/"+selectedNrId;
}


function showModalAddNr(){
    const AddModal = document.getElementById('addModal');
    AddModal.style.display = 'block';
    modalVisible = true;
}
function hideModalAddNr(){
    const AddModal = document.getElementById('addModal');
    AddModal.style.display="none";
    modalVisible = false;
}



function showMenuNr() {
    const dropdownMenu = document.getElementById('dropdownMenu');
    dropdownMenu.classList.toggle('active');
}