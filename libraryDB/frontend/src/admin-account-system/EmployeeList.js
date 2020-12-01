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

const EmployeeList = (props) => (
    <List {...props} title="Employees">
        <Datagrid>
            <TextField source='name'/>
            <TextField source='surname'/>
            <TextField source='role'/>
            <EditButton basePath='/employee'/>
            <DeleteButton basePath='/employee' />
        </Datagrid>
    </List>
)


export default EmployeeList