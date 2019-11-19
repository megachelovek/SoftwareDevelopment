import React from 'react';

var testHeaders = ["name", "surname", "address"];
var testDataFromServer = [
  {
    "name": "mersedez amg",
    "price": "123333",
    "country": "france"
  },
  {
    "name": "audi amg",
    "price": "123333",
    "country": "germany"
  },
  {
    "name": "lada amg",
    "price": "123333",
    "country": "russia"
  }
]


class MainTable extends React.Component {
  constructor(props) {
    super(props);
    this.state = { data: [testDataFromServer], headers: [testHeaders] };
  }
  update(data, headers) {
    this.setState({ data: data });
    if (headers !== null) {
      this.setState({ headers: headers });
    }
  }
  render() {
    console.log(this.state.data[0])
    var arrayObjects = this.state.data;
    return (
      <div>
        {this.state.headers.map(item => (
          <div className="tableHeader" key={item}>{item}
          </div>
        ))}
        {
        arrayObjects[0].forEach(ite2m => (
          <div className="tableString" key={ite2m}>2{ite2m}
          </div>
        ))
        }
      </div>
    )
  }
}


export default MainTable;