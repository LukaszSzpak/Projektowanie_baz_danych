import * as React from 'react';
import { cloneElement, useMemo } from 'react';
import PropTypes from 'prop-types';
import {List, 
    Datagrid, 
    TextField, 
    EditButton, 
    DeleteButton,
    useListContext,
    TopToolbar,
    sanitizeListRestProps,
    CreateButton,
    } from 'react-admin'

const UserList = (props) => (
    <List {...props} title="Users">
        <Datagrid>
            <TextField source='id'/>
            <TextField source='name'/>
            <TextField source='surname'/>
            <TextField source='email'/>
            <EditButton/>
            <DeleteButton/>
        </Datagrid>
    </List>
)

export default UserList