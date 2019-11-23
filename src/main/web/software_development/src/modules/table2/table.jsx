import React from 'react';

class Table2 extends React.Component {
    constructor(props) {
        super(props);
        this.state = { data: this.props.tableData, headers: this.props.tableHeader };
    }
    update(data) {
        this.setState({ data: data });
    }
    render() { 
        return (
            <div className="container tableMain">
                <div className="row headerMain">
                {
                    this.state.headers.map(item => {
                        return <div className="col-sm headerColumn" key={item}>{item}</div>
                    })
                }
                </div>
                {
                    this.state.data.map(item => {
                        return <div className="row dataMain" key={item}>
                         {
                             Object.keys(item).map(itemInner => {
                                return <div className="col-sm dataColumn" key={item[itemInner]}>
                                {item[itemInner]}
                                </div>
                         })
                        }
                        </div>
                    })
                }
            </div>
        );

    }
}


export default Table2;
