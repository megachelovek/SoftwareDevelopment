import axios from 'axios';

export async function editItem(nameService, itemId, item) {
  console.log("UPDATE ITEM ID=" + itemId);
  let authorization = localStorage.getItem("Authorization");
  let type = localStorage.getItem("tokenType");
  return new Promise((resolve, reject) => {
    axios.put('http://localhost:8080/' + nameService + '/edit',
      { headers: { Authorization: type + ' ' + authorization,"Content-Type": "application/json" },data: item}
    ).then(data => resolve(data)).catch(error => reject(error));
  }
  )
}

export function createItem(nameService, item) {
  console.log("CREATE ITEM=" + item);
  let authorization = localStorage.getItem("Authorization");
  let type = localStorage.getItem("tokenType");
  return new Promise((resolve, reject) => {
    axios.post('http://localhost:8080/' + nameService + '/add',
      { headers: { Authorization: type + ' ' + authorization,"Content-Type": "application/json" },data: item}
    ).then(data => resolve(data)).catch(error => reject(error));
  }
  )
}

export async function getItems(nameService) {
  let authorization = localStorage.getItem("Authorization");
  let type = localStorage.getItem("tokenType");
  console.log(nameService + "auth=" + type + ' ' + authorization);

  return new Promise((resolve, reject) => {
    axios.get('http://localhost:8080/' + nameService + '/getAll',
      { headers: { Authorization: type + ' ' + authorization } }
    ).then(data => resolve(data)).catch(error => reject(error));
  }
  )
}

export function deleteItem(nameService, itemId) {
  console.log("DELETE ITEM ID=" + itemId);
  let authorization = localStorage.getItem("Authorization");
  let type = localStorage.getItem("tokenType");

   return new Promise((resolve, reject) => {
    axios.delete('http://localhost:8080/' + nameService + '/'+itemId,
      { headers: { Authorization: type + ' ' + authorization } }
    ).then(data => resolve(data)).catch(error => reject(error));
  }
  )
}

export async function authorize(name, password) {
  return new Promise((resolve, reject) => {
    axios.post('http://localhost:8080/api/auth/signin',
      {
        "user": name,
        "username": name,
        "password": password
      }
    ).then(data => resolve(data)).catch(error => reject(error));
  });
}

// function maxId() {
//   var maxId = 0;
//   demoData.forEach(element => {
//     if (maxId < element.id) {
//       maxId = element.id;
//     }
//   });
//   return maxId;
// }
