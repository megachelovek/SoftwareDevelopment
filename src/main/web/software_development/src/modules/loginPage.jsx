import React from 'react';
import {withRouter} from 'react-router-dom'
import {authorize} from './dataExchangeService'
import { Redirect } from 'react-router-dom'
import CarPage from './carPage';

class LoginPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = { data: this.props.tableData, serviceUrl: this.props.serviceUrl };
    }
    update(data) {
        this.setState({ data: data });
    }
    handleSubmit(e) {
        e.preventDefault();
        let response = authorize(e.currentTarget["login"].value,e.currentTarget["password"].value);
        response.then(
            function (response) {
                if (response.data.tokenType ==="Bearer"){
                    localStorage.setItem("tokenType",response.data.tokenType);
                    localStorage.setItem("Authorization",response.data.accessToken);
                    console.log("LOGIN OK!");
                    window.location.href = '/carpage';
                }
                else{
                    alert("Неправильный логин");
                    console.log("login bad!");
                }
              }
          );
        
    }
    render() {
        return (
            <div className="login-form">
                <form onSubmit={this.handleSubmit}>
                    <div className="loginBlock">
                        <label className="pull-left checkbox-inline">Логин</label>
                        <input className="form-control" type="text" id="login" defaultValue="admin"></input>
                        <label className="pull-left checkbox-inline">Пароль</label>
                        <input className="form-control" type="text" id="password" defaultValue="admin"></input>
                    </div>
                    <input className="btn btn-primary btn-block" type="submit" value="Войти" />
                </form>
            </div>
        );

    }
}

export default LoginPage;
