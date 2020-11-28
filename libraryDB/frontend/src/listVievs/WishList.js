import * as React from "react";
import { cloneElement, useMemo } from 'react';
import { List, Datagrid, TextField, NumberField, useListContext, ExportButton, CreateButton, TopToolbar, sanitizeListRestProps} from 'react-admin';
import {Grid, Button} from '@material-ui/core'
import PropTypes from 'prop-types';


export const PostList = (props) => (
    <List {...props} actions={<ListActions />}>
        <Datagrid>
            <NumberField source="id" />
            <TextField source="title" />
            <TextField source="author" />
            <TextField source="description" />
            <BooleanField source="avalible" />
        </Datagrid>
    </List>
);

export default PostList