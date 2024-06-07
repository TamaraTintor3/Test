import { Button, DialogContent, Grid } from '@material-ui/core';
import React from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import Input from '../Components/Input';
import * as userDataActions from '../Redux/Actions/userDataActions';
const MainPage = (props) => {
  return (
    <div>
      <h1>Podaci o korisniku</h1>
      <DialogContent>
        <Grid container direction='row'>
          <Grid container direction='column' spacing={2}>
            <Grid item>
              <Input
                size='small'
                id={'username'}
                label={'Korisničko ime'}
                autoFocus={true}
                variant='outlined'
                value={props.userData.username}
                onChange={(event) => {
                  let userData = { ...props.userData };
                  userData.username = event.value;
                  props.actions.onChangeField({
                    id: 'userData',
                    value: userData,
                  });
                }}
              />
            </Grid>
            <Grid item>
              <Input
                size='small'
                id={'email'}
                label={'E-mail'}
                autoFocus={true}
                variant='outlined'
                value={props.userData.email}
                onChange={(event) => {
                  let userData = { ...props.userData };
                  userData.email = event.value;
                  props.actions.onChangeField({
                    id: 'userData',
                    value: userData,
                  });
                }}
              />
            </Grid>
            <Grid item>
              <Input
                size='small'
                id={'firstName'}
                label={'Ime'}
                autoFocus={true}
                variant='outlined'
                value={props.userData.firstName}
                onChange={(event) => {
                  let userData = { ...props.userData };
                  userData.firstName = event.value;
                  props.actions.onChangeField({
                    id: 'userData',
                    value: userData,
                  });
                }}
              />
            </Grid>
            <Grid item>
              <Input
                size='small'
                id={'lastName'}
                label={'Prezime'}
                autoFocus={true}
                variant='outlined'
                value={props.userData.lastName}
                onChange={(event) => {
                  let userData = { ...props.userData };
                  userData.lastName = event.value;
                  props.actions.onChangeField({
                    id: 'userData',
                    value: userData,
                  });
                }}
              />
            </Grid>
            <Grid item>
              <Input
                size='small'
                id={'organization'}
                label={'Organizacija'}
                autoFocus={true}
                variant='outlined'
                value={props.userData.organization}
                onChange={(event) => {
                  let userData = { ...props.userData };
                  userData.organization = event.value;
                  props.actions.onChangeField({
                    id: 'userData',
                    value: userData,
                  });
                }}
              />
            </Grid>
            <Grid item>
              <Input
                size='small'
                id={'organizationUnit'}
                label={'Organizaciona jedinica'}
                autoFocus={true}
                variant='outlined'
                value={props.userData.organizationUnit}
                onChange={(event) => {
                  let userData = { ...props.userData };
                  userData.organizationUnit = event.value;
                  props.actions.onChangeField({
                    id: 'userData',
                    value: userData,
                  });
                }}
              />
            </Grid>
            <Grid item>
              <Input
                size='small'
                id={'stateOrProvince'}
                label={'Pokraina (oblast)'}
                autoFocus={true}
                variant='outlined'
                value={props.userData.stateOrProvince}
                onChange={(event) => {
                  let userData = { ...props.userData };
                  userData.stateOrProvince = event.value;
                  props.actions.onChangeField({
                    id: 'userData',
                    value: userData,
                  });
                }}
              />
            </Grid>
            <Grid item>
              <Input
                size='small'
                id={'cityOrLocation'}
                label={'Grad'}
                autoFocus={true}
                variant='outlined'
                value={props.userData.cityOrLocation}
                onChange={(event) => {
                  let userData = { ...props.userData };
                  userData.cityOrLocation = event.value;
                  props.actions.onChangeField({
                    id: 'userData',
                    value: userData,
                  });
                }}
              />
            </Grid>
            <Grid item>
              <Input
                size='small'
                id={'countryCode'}
                label={'Kod države'}
                autoFocus={true}
                variant='outlined'
                value={props.userData.countryCode}
                onChange={(event) => {
                  let userData = { ...props.userData };
                  userData.countryCode = event.value;
                  props.actions.onChangeField({
                    id: 'userData',
                    value: userData,
                  });
                }}
              />
            </Grid>
            <Grid item>
              <Button
                id='btnSave'
                onClick={() => {
                  props.actions.saveData(props.userData);
                }}
              >
                {'Save'}
              </Button>
            </Grid>
          </Grid>
        </Grid>
      </DialogContent>
    </div>
  );
};
const mapStateToProps = (state) => {
  return { ...state.userDataReducer }; //Bila greska
};
const mapDispatchToProps = (dispatch) => {
  return {
    actions: {
      onChangeField: bindActionCreators(userDataActions.onChangeField, dispatch),
      saveData: bindActionCreators(userDataActions.saveData, dispatch),
    },
  };
};
export default connect(mapStateToProps, mapDispatchToProps)(MainPage);
