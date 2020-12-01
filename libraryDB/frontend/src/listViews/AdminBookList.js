import * as React from "react";
import { cloneElement, useMemo } from 'react';
import {
    List,
    Datagrid,
    TextField,
    NumberField,
    useListContext,
    BooleanField,
    ExportButton,
    CreateButton,
    TopToolbar,
    sanitizeListRestProps,
    EditButton,
    DeleteButton
} from 'react-admin';
import {Grid, Button} from '@material-ui/core'
import PropTypes from 'prop-types';


export const AdminBookList = (props) => (
    <List {...props} filters={BookFilter}>
        <Datagrid>
            <NumberField source="id" />
            <TextField source="title" />
            <TextField source="author" />
            <TextField source="description" />
            <BooleanField source="available" />
            <EditButton></EditButton>
            <DeleteButton></DeleteButton>
        </Datagrid>
    </List>
);

const BookFilter = (props) => (
    <Filter {...props}>
        <TextInput label="Search" source="q" alwaysOn />
        <TextInput label="Title" source="title" defaultValue="Hello, World!" />
    </Filter>
);

export default AdminBookList