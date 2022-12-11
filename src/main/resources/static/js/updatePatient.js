window.addEventListener('load', function () {

    const url = '/patients';

    const formularioUpdatePaciente = document.querySelector('#update_paciente');

    formularioUpdatePaciente.addEventListener('submit', function (event) {

        const formDataUpdatePaciente = {
            id: parseInt(document.querySelector('#id_paciente').value),

            apellido: document.querySelector('#apellido').value,
            nombre: document.querySelector('#nombre').value,
            email: document.querySelector('#email').value,
            dni: parseInt(document.querySelector('#dni').value),
            fechaIngreso: document.querySelector('#fecha_ingreso').value,
            domicilio: {
                calle: document.querySelector('#calle').value,
                numero: parseInt(document.querySelector('#numero').value),
                localidad: document.querySelector('#localidad').value,
                provincia: document.querySelector('#provincia').value
            }
        };

        const settingsUpdatePaciente = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formDataUpdatePaciente)
        }

        fetch(url, settingsUpdatePaciente)
            .then(response => response.json())
            .then(data => {
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong></strong> Paciente actualizado </div>'

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
        document.querySelector('#id_paciente').value = "";
        document.querySelector('#apellido').value = "";
        document.querySelector('#nombre').value = "";
        document.querySelector('#email').value = "";
        document.querySelector('#dni').value = "";
        document.querySelector('#fecha_ingreso').value = "";
        document.querySelector('#calle').value = "";
        document.querySelector('#numero').value = "";
        document.querySelector('#localidad').value = "";
        document.querySelector('#provincia').value = "";
    }

});