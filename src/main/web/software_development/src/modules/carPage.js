import React from 'react';
import MainTable from './table/table'
// import DemoTable from './tablesOLD/index.jsx.js'

var demoData = [
  { id: 1, name: 'Test1', email: 'test1@test.com', choose: 'First'},
  { id: 2, name: 'Test2', email: 'test2@test.com', choose: 'Second' },
  { id: 3, name: 'Test3', email: 'test3@test.com', choose: 'First' },
  { id: 4, name: 'Test4', email: 'test4@test.com', choose: 'Third' },
];

class CarPage extends React.Component {
  constructor(){
    super();
    this.state = { data: demoData };
  }
  update(data){
    this.setState({ data: data });
  }
  render() {
      return (
        <MainTable dataFromServer={demoData}/>
      );
      
    }
  }

  
export default CarPage;
