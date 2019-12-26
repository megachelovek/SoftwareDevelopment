import React from 'react';
import { Link } from 'react-router-dom';
import { deleteItem } from '../dataExchangeService'
import 'bootstrap/dist/css/bootstrap.css';

class Table2 extends React.Component {
    constructor(props) {
        super(props);
        this.state = { data: this.props.tableData.data, serviceUrl: this.props.serviceUrl };
    }
    update(data) {
        this.setState({ data: data });
    }
    render() {
        console.log("table= " + JSON.stringify(this.state.data[0]));
        const tableName = this.state.serviceUrl;
        return (
            <div className="tableMain2 table-responsive">
                <table className="table">

                    <thead className="thead-dark">
                        {
                            Object.keys(this.state.data[0]).map(header => {
                                return <th className="" key={header}>{header}</th>
                            })
                        }
                        <th className="" key={"header"}>
                            <Link to={{
                                pathname: '/editPage',
                                editData: {
                                    isEdit: false,
                                    item: this.state.data[0]
                                }
                            }}>Создать</Link>
                        </th>
                        <th className="" key={"header"}>

                        </th>
                    </thead>
                    <tbody>
                        {
                            this.state.data.map(item => {
                                return (
                                    <tr className="">
                                        {
                                            Object.keys(item).map(itemInner => {
                                                return <td className="col-sm dataColumn" key={item[itemInner]}>
                                                    {item[itemInner]}
                                                </td>
                                            })
                                        }
                                        <td className="" key={item + "edit"}>
                                            <Link to={{
                                                pathname: '/editPage',
                                                editData: {
                                                    isEdit: true,
                                                    urlService:tableName,
                                                    item
                                                }
                                            }}>Изменить</Link>
                                        </td>
                                        <td className="col-sm headerColumn" key={item + "delete"}>
                                            <a href="" onclick={deleteItem("", item["id"])}>Удалить</a>
                                        </td>
                                    </tr>
                                )
                            })
                        }
                    </tbody>
                </table>
            </div>
        );

    }
}


export default Table2;
