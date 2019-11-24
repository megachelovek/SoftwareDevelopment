import React from 'react';
import { Link } from 'react-router-dom';

class Table2 extends React.Component {
    constructor(props) {
        super(props);
        this.state = { data: this.props.tableData,counter:0 };
    }
    update(data) {
        this.setState({ data: data });
    }
    render() {
        console.log("table= " + JSON.stringify(this.state.data[0]));
        return (
            <div className="center-block col-md-4 container tableMain">
                <div className="row headerMain">
                    {
                        Object.keys(this.state.data[0]).map(header => {
                            return <div className="col-sm headerColumn" key={header}>{header}</div>
                        })
                    }
                    <div className="col-sm headerColumn" key={"header"}>
                        <Link to={{
                            pathname: '/editPage',
                            editData: {
                                isEdit:false,
                                item:this.state.data[0]
                            }
                        }}>Создать</Link>
                    </div>
                </div>
                {
                    this.state.data.map(item => {
                        return <div className="row dataMain" key={item}>
                            <div className="tableRow">
                                {
                                    Object.keys(item).map(itemInner => {
                                        return <div className="col-sm dataColumn" key={item[itemInner]}>
                                            {item[itemInner]}
                                        </div>
                                    })
                                }
                                <div className="col-sm headerColumn" key={item+"edit"}>
                                    <Link to={{
                                        pathname: '/editPage',
                                        editData: {
                                            isEdit:true,
                                            item
                                        }
                                    }}>Изменить</Link>
                                </div>
                                <div className="col-sm headerColumn" key={item+"delete"}>
                                    <Link to={{
                                        pathname: '/editPage',
                                        editData: {
                                            item
                                        }
                                    }}>Удалить</Link>
                                </div>
                            </div>
                        </div>
                    })
                }
            </div>
        );

    }
}


export default Table2;
