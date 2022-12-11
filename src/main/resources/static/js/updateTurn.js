window.addEventListener('load', function () {

    const url = '/turns';

    const formularioUpdateTurno = document.querySelector('#update_turno');

    formularioUpdateTurno.addEventListener('submit', function (event) {

        const formDataUpdateTurno = {
            id: parseInt(document.querySelector('#id_turno').value),
            odontologo: {
                id: parseInt(document.querySelector('#id_odontologo').value)
            },
            paciente: {
                id: parseInt(document.querySelector('#id_paciente').value)
            },
            fecha: document.querySelector('#fecha_turno').value
        };

        const settingsUpdateTurno = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formDataUpdateTurno)
        }

        fetch(url, settingsUpdateTurno)
            .then(response => response.json())
            .then(data => {
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong></strong> Odontologo agregado </div>'

                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();

            })
            .catch(error => {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error intente nuevamente</strong> </div>'

                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('#id_turno').value = "";
        document.querySelector('#id_odontologo').value = "";
        document.querySelector('#id_paciente').value = "";
        document.querySelector('#fecha_turno').value = "";
    }

});