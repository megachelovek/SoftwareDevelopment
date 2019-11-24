import React from 'react';
import Table2 from './table2/table'
import Menu from './menu';
import getItems from './dataExchangeService'

class CarPage extends React.Component {
  constructor() {
    super();
    this.state = { data: getItems() };
  }
  update(data) {
    this.setState({ data: data });
  }
  render() {
    return (
      <div>
        <Menu></Menu>
        <Table2 tableData={this.state.data}  />
      </div>
    );

  }
}


export default CarPage;
