const host = `http://localhost`;
const port = 8080

function login(){
  let user =  $(`#user`).val();
  let password =  $(`#password`).val();

  let request_body = {
    user: user,
    password: password
  }
  
  $.ajax({
    method: 'POST',
    body: request_body,
    url:`${host}:${port}/login`,
    success: function(data) {
      res = JSON.parse(data);
      $(`#output`).text('Resultado: ' + res.output);
    },
    error: function(error) {
      $(`#output`).text('Se produjo un error');
    }
  })
}