import React from 'react';
import Menu from './menu';

class EditPage2 extends React.Component {
    constructor(props) {
        super(props);
        this.state = { editData:props.location.editData};
        console.log("ITEM= "+ JSON.parse(this.state.editData));
    }
    render() {
        console.log("ITEM= "+ JSON.parse(this.state.editData));
        return (
            <div>
                <Menu></Menu>
                <div className="row headerMain">
                    {
                        Object.keys(this.state.editData.item[0]).map(header => {
                            return <div className="row headerColumn" key={header}>
                            <input type="text"></input>
                            </div>
                        })
                    }
                </div>
                <button>Сохранить</button>
            </div>
        );
    }
}


export default EditPage2;
