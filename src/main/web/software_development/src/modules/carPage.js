import React from 'react';
import Table2 from './table2/table'
import Menu from './menu';
import { getItems } from './dataExchangeService'
import Loader from './loader';

var serviceUrl = "carpage"
let res;

class CarPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = { data: null }
  }
  // update(data) {
  //   this.setState({ data: data });
  // }
  getData() {
    getItems("car")
    .then(response=> {
      this.setState({ data: response })}
    , error => {console.log("ОШИИИБКА !!!!!")})
    // res = getItems("car");
    // res.then(
    //   this.setState({ data: res })
    // );
  }
  getElem() {
    return (
      <div>
        <Menu></Menu>
        <Table2 tableData={this.state.data} serviceUrl={serviceUrl} />
      </div>
    );
  }
  componentDidMount() {
    this.getData();
  }
  render() {
    return (
      <div>
        <div>
          { this.state.data!=null && this.state.data.constructor.name!=="Promise"
            ?
            this.getElem()
            :
              <div>Загрузка...</div>
          }
        </div>
      </div>
    )
  }
}
export default CarPage;
