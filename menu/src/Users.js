import React from 'react';
import data from './data.json'

class Users extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        const {data, fetchUsers} = this.props;
        return (
            <div className='container'>
                data.map
            </div>
        )
    }    
}

export default Users