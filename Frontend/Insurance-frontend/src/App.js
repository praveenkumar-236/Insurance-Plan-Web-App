import React, { useState } from 'react';
import {
  TextField,
  Button,
  Select,
  MenuItem,
  FormControl,
  InputLabel,
  Grid,
  Paper,
  Typography,
  CircularProgress,
  capitalize
} from '@mui/material';

function App() {
  const [customerDetail, setCustomerDetail] = useState({
    dob: '',
    gender: '',
    annualIncome: 0,
    medicalCondition: ''
  });
  const [eligiblePlans, setEligiblePlans] = useState([]);
  const [suggestedPlan, setSuggestedPlan] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setCustomerDetail((prevCustomerDetail) => ({
      ...prevCustomerDetail,
      [name]: value
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Reset previous state
    setEligiblePlans([]);
    setSuggestedPlan(null);
    setError(null);

    try {
      setLoading(true);

      const response = await fetch('http://localhost:8080/filtered-plans', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ customerDetail, allPacks: [] })
      });

      if (!response.ok) {
        throw new Error('Failed to fetch data');
      }

      const jsonData = await response.json();
      const eligiblePlans = jsonData.response.eligiblePlan;
      setEligiblePlans(eligiblePlans);
      setSuggestedPlan(eligiblePlans[0]); // Set the first eligible plan as the default selection
    } catch (error) {
      setError('An error occurred. Please try again later.');
      console.log('Error:', error);
    } finally {
      setLoading(false);
    }
  };

  const isFormValid = () => {
    // Implement your form validation logic here
    // Return true if all fields are valid, otherwise false
    // You can set validation rules and check the values in the customerDetail object
    // For simplicity, let's assume the form is always valid in this example
    return true;
  };

  return (
    <div>
      <header style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', paddingBottom: '10px' }}>
        <div>
          <img src="https://www.licindia.in/o/liferaytheme-theme/images/logo.png" alt="Logo" style={{ width: '100px', height: 'auto' }} />
        </div>

      </header>
      <div className="container" style={{ width: '200%', maxWidth: '800px' }}>
        <Grid container spacing={2}>
          <Grid item xs={12} sm={6}>
            <Paper elevation={3} sx={{ p: 2 }}>
              <Typography variant="h5" sx={{ mb: 2 }}>
                Enter Customer Details
              </Typography>
              <form onSubmit={handleSubmit}>
                <TextField
                  label="Date of Birth"
                  type="date"
                  name="dob"
                  value={customerDetail.dob}
                  onChange={handleChange}
                  InputLabelProps={{
                    shrink: true,
                  }}
                  InputProps={{
                    style: { width: '100%' },
                  }}
                  sx={{ mb: 2 }}
                />

                <FormControl sx={{ width: '100%', mb: 2 }}>
                  <InputLabel>Gender</InputLabel>
                  <Select
                    label="Gender"
                    name="gender"
                    value={customerDetail.gender}
                    onChange={handleChange}
                  >
                    <MenuItem value="Male">Male</MenuItem>
                    <MenuItem value="Female">Female</MenuItem>
                  </Select>
                </FormControl>

                <TextField
                  label="Annual Income"
                  type="number"
                  name="annualIncome"
                  value={customerDetail.annualIncome}
                  onChange={handleChange}
                  InputProps={{
                    style: { width: '100%' },
                  }}
                  sx={{ mb: 2 }}
                />

                <FormControl sx={{ width: '100%', mb: 2 }}>
                  <InputLabel>Medical Condition</InputLabel>
                  <Select
                    label="Medical Condition"
                    name="medicalCondition"
                    value={customerDetail.medicalCondition}
                    onChange={handleChange}
                  >
                    {/* <MenuItem value="Yes">Yes</MenuItem>
                    <MenuItem value="No">No</MenuItem> */}
                     <MenuItem value="No">Healthy</MenuItem>
                    <MenuItem value="Yes">Pre-Existing Condition</MenuItem>
                  </Select>
                </FormControl>

                <Button
                  type="submit"
                  variant="contained"
                  color="primary"
                  disabled={!isFormValid() || loading}
                >
                  {loading ? (
                    <CircularProgress size={24} color="primary" />
                  ) : (
                    'Submit'
                  )}
                </Button>
                {error && (
                  <Typography variant="body1" color="error" sx={{ mt: 2 }}>
                    {error}
                  </Typography>
                )}
              </form>
            </Paper>
          </Grid>

          <Grid item xs={12} sm={6}>
            {eligiblePlans.length > 0 && (
              <Paper elevation={3} sx={{ p: 2 }}>
                <Typography variant="h5" sx={{ mb: 2 }}>
                  Suggested Plans
                </Typography>
                <FormControl sx={{ width: '100%', mb: 2 }}>
                  <InputLabel>Select Plan</InputLabel>
                  <Select
                    label="Select Plan"
                    value={suggestedPlan ? suggestedPlan.id : ''}
                    onChange={(e) => {
                      const selectedPlanId = e.target.value;
                      const selectedPlan = eligiblePlans.find((plan) => plan.id === selectedPlanId);
                      setSuggestedPlan(selectedPlan);
                    }}
                  >
                    {eligiblePlans.map((plan) => (
                      <MenuItem key={plan.id} value={plan.id}>
                        {plan.planName.toUpperCase()} 
                      </MenuItem>
                    ))}
                  </Select>
                </FormControl>
                {suggestedPlan && (
                  <>
                    {/* <Typography variant="body1" sx={{ mb: 1 }} textTransform={'capitalize'}>
                      Plan Name: {suggestedPlan.planName}
                    </Typography> */}
                    <Typography variant="body1" textTransform={'capitalize'}>
                     Starts From <b>${suggestedPlan.price}</b>
                    </Typography>
                  </>
                )}
              </Paper>
            )}
          </Grid>
        </Grid>
      </div>
      <footer
        style={{
          textAlign: 'center',
          padding: '10px',
          borderTop: '1px solid #ccc',
          marginTop: '20px',
        }}
      >
        <Typography variant="caption" color="textSecondary">
          © 2023 Praveen Insurance Company. All rights reserved.
        </Typography>
      </footer>
    </div>
  );
}

export default App;
