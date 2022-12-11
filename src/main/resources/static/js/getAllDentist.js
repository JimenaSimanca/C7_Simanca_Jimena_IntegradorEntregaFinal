window.addEventListener('load', function () {
        const url = '/dentists';
        const settings = {
            method: 'GET'
        }

        fetch(url,settings)
            .then(response => response.json())
            .then(data => {
                for(odontologo of data){
                    var table = document.getElementById("odontologoTable");
                    var odontologoRow =table.insertRow();
                    let tr_id = 'tr_' + odontologo.id;
                    odontologoRow.id = tr_id;

                    let deleteLink='<a id=\"a_delete_'+odontologo.id+'\"'+
                        ' href=\"#\" onclick=\"deleteBy('+odontologo.id+')\"'+
                        ' class=\"link-danger\">Borrar</a>';

                    let updateLink='<a id=\"a_update_'+odontologo.id+'\"'+
                        ' href=\"../update_odontologo.html\"'+
                        ' class=\"link-danger\">Actualizar</a>';
                    odontologoRow.innerHTML =
                        '<td class=\"td_id\">' + odontologo.id + '</td>' +
                        '<td class=\"td_apellido\">' + odontologo.apellido.toUpperCase() + '</td>' +
                        '<td class=\"td_nombre\">' + odontologo.nombre.toUpperCase() + '</td>' +
                        '<td class=\"td_matricula\">' + odontologo.matricula + '</td>'+
                        '<td>'+deleteLink+'</td>'+
                        '<td>'+updateLink+'</td>';

                };

            })

})