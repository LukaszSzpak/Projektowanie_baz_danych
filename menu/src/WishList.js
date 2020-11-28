import * as React from "react";
import { cloneElement, useMemo } from 'react';
import {
    List,
    Datagrid,
    TextField,
    NumberField,
    useListContext,
    ExportButton,
    CreateButton,
    TopToolbar,
    sanitizeListRestProps,
    BooleanField,
    DeleteButton
} from 'react-admin';
import { BulkDeleteButton } from 'react-admin';
import { Fragment } from 'react';
import {Grid, Button} from '@material-ui/core'
import PropTypes from 'prop-types';
import localStorageDataProvider from 'ra-data-local-storage';
import { Admin, Resource } from 'react-admin';
import AddToWishlistButton from "./ButtonWishlist";


const PostBulkActionButtons = props => (
    <Fragment>
        <BulkDeleteButton {...props} />
        <AddToWishlistButton label = "Add to wish list" {...props}> </AddToWishlistButton>
    </Fragment>
);

 
const PostList = (props) => (
    <List {...props} bulkActionButtons={<PostBulkActionButtons />}>
        <Datagrid>
            <NumberField source="id" />
            <TextField source="title" />
            <TextField source="author" />
            <TextField source="description" />
            <BooleanField source="avalible" />
            <DeleteButton></DeleteButton>
        </Datagrid>
    </List>
);
 

export default PostList