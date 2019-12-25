import React from 'react';
import Table2 from './table2/table'
import Menu from './menu';
import { getItems } from './dataExchangeService'
import Loader from './loader';

var serviceUrl = "carpage"

class CarPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = { data: null }
  }
  update(data) {
    this.setState({ data: data });
  }
  getData() {
    let res = getItems("car");
    res.then(
      this.setState({ data: res })
    );
  }
  getElem() {
    return (
      <div>
        <Menu></Menu>
        <Table2 tableData={this.state.data} servideUrl={serviceUrl} />
      </div>
    );
  }
  componentDidUpdate() {
    this.getData();
  }
  render() {
    
    // if (this.state.data !== null ) {
    //   if (this.state.data.constructor.name !== "Promise") {
    //     this.getData().then(
    //       this.getElem()
    //     );
    //   }
    //   else{
    //     return (
    //       <Loader></Loader>
    //     );
    //   }
    // } else {
    //   this.getData();
    //   return (
    //     <Loader></Loader>
    //   );
    // }

  }
}
export default CarPage;
