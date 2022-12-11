function deleteTurnoBy(id){
    const url='/turns/'+id;

    const settings = {
        method:'DELETE'
    }

    fetch(url,settings)
    .then(response=>response.json())

    let row_id='#tr_'+id;
    document.querySelector(row_id).remove();
}