import * as React from "react";
import { cloneElement, useMemo } from 'react';
import { List, Datagrid, TextField, NumberField, useListContext, BooleanField, ExportButton, CreateButton, TopToolbar, sanitizeListRestProps} from 'react-admin';
import {Grid, Button} from '@material-ui/core'
import PropTypes from 'prop-types';


export const PostList = (props) => (
    <List {...props} title = 'wishlist'>
        <Datagrid>
            <NumberField source="id" />
            <TextField source="title" />
            <TextField source="author" />
            <TextField source="description" />
            <BooleanField source="avalible" />
            <ExportButton></ExportButton>
            <CreateButton></CreateButton>
        </Datagrid>
    </List>
);

export default PostList