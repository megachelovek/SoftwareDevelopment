import React from 'react';
import Table2 from './table2/table'

var demoData = [
  { id: 1, name: 'Test1', email: 'test1@test.com', choose: 'First' },
  { id: 2, name: 'Test2', email: 'test2@test.com', choose: 'Second' },
  { id: 3, name: 'Test3', email: 'test3@test.com', choose: 'First' },
  { id: 4, name: 'Test4', email: 'test4@test.com', choose: 'Third' },
];
var demoHeader = ["Id", "Name", "Email", "Choose"]

class CarPage extends React.Component {
  constructor(){
    super();
    this.state = { data: demoData };
  }
  update(data){
    this.setState({ data: data });
  }
  render() {

    var data = this.state.data;
    return (
        <Table2 tableData={demoData} tableHeader={demoHeader}/>
  );

  }
}


export default CarPage;
