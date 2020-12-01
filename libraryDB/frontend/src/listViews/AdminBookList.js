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


export const PostList = (props) => (
    <List {...props}>
        <Datagrid>
            <NumberField source="id" />
            <TextField source="title" />
            <TextField source="author" />
            <TextField source="description" />
            <BooleanField source="avalible" />
            <ExportButton></ExportButton>
            <CreateButton></CreateButton>
            <EditButton></EditButton>
            <DeleteButton></DeleteButton>
        </Datagrid>
    </List>
);

export default PostList