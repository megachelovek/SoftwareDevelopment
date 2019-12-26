import React from 'react';
import Menu from './menu';
import { createItem, editItem } from './dataExchangeService'

var globalIsEdit, globalurlService,globalmainObject;

class EditObjectPage extends React.Component {

  constructor(props) {
    super(props);
    globalmainObject = props.location.editData.item;
    globalIsEdit = props.location.editData.isEdit
    globalurlService = props.location.editData.urlService;
  }
  isCreate(key) {
    if (globalIsEdit) {
      return globalmainObject[key];
      this.handleSubmit = this.handleSubmit.bind(this);
    }
  }
  handleSubmit(e) {
    e.preventDefault();
    const formData = {};
    for (let i = 0; i < e.currentTarget.length; i++) {
      var idKey = e.currentTarget[i].id;
      if (idKey !== "" && idKey !== '' && idKey !== undefined && idKey !== "\"\"" && idKey !== null) {
        formData[idKey] = e.currentTarget[i].value;
      }
    }

    if (globalIsEdit) {
      editItem(globalurlService, globalmainObject.id, formData);
    } else {
      createItem(globalurlService, formData);
    }
  }
  render() {
    const mainObject = globalmainObject;

    return (
      
      <div className="mainEditBlock">
        <Menu></Menu>
        <div className="container tableMain2">
          <form className="form-group" onSubmit={this.handleSubmit}>
            {
              Object.keys(mainObject).map(key => {
                if (key !== "id") {
                  return <div  className="form-group">
                    <label for="exampleFormControlInput1">{key}</label>
                    <input type="text" className="form-control" key={mainObject[key]} id={key} defaultValue={this.isCreate(key)}></input>
                  </div >
                }
              })
            }
            <input className="btn btn-primary mb-2" type="submit" value="Сохранить" />
          </form>
        </div>

      </div>
    );

  }
}


export default EditObjectPage;