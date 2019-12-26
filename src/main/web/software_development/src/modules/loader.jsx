import Spinner from "react-bootstrap-spinner";
import React from "react";

export default class Loader extends React.Component{
render(){
return (
<div className="fullScreen flex column center table-dark">
<Spinner animation="border" role="status">
<span className="sr-only">Loading...></span>
</Spinner>
<div className="loadingText">Загрузка</div>
</div>)
}
}

